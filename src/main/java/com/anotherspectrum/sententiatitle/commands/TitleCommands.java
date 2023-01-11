package com.anotherspectrum.sententiatitle.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.anotherspectrum.anotherlibrary.utils.StringUtil;
import com.anotherspectrum.sententiatitle.SententiaTitle;
import com.anotherspectrum.sententiatitle.title.TitleFile;
import com.anotherspectrum.sententiatitle.title.TitleMenu;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@CommandAlias("title|칭호")
public class TitleCommands extends BaseCommand {

    private SententiaTitle main;

    public TitleCommands(SententiaTitle main) {
        this.main = main;
    }


    /**
     * /title|칭호 만 입력했을 시 TitleMenu를 오픈하는 커맨드
     * @param sender
     */
    @Default
    public void base(@NotNull CommandSender sender) {

        if (!(sender instanceof Player)) return;
        Player player = (Player) sender;

        new TitleMenu().open(player);
    }

    /**
     * /title|칭호 set titleName 입력 시 칭호를 제작하는 커맨드
     * @param sender
     * @param titleName
     */
    @CommandPermission("admin.bum.else_bum")
    @Subcommand("set")
    @Description("칭호를 제작할 수 있습니다.")
    public void set(@NotNull CommandSender sender, String titleName) {

        if (!(sender instanceof Player)) return;

        Player player = (Player) sender;
        /*Player target = (Player) Bukkit.getServer().getLogger();*/
        for (OfflinePlayer all : Bukkit.getOfflinePlayers())


        if (titleName.length() == 0) {
            player.sendMessage(StringUtil.format("칭호의 이름을 설정하시오."));
            return;
        }
        TitleFile titleFile = new TitleFile(player);
        if (titleFile.getTitle().contains(titleName)) {
            player.sendMessage(titleName + " 라는 칭호는 이미 존재합니다.");
            return;
        }

        main.getTitleFileTett().addTitle(titleName);
        main.getTitleFileTett().save();

//        TitleFile titleFile1 = new TitleFile(all);

//        titleFile1.addTitle(titleName);
//        titleFile1.save();

        titleFile.addTitle(titleName);
        titleFile.save();

        player.sendMessage(titleName.replace(titleName, "[" + titleName + "]") + " 칭호를 제작하였습니다");

    }

    /**
     * /title|칭호 give titleName @players 입력 시 플레이어에게 칭호를 부여하는 커맨드
     * @param sender
     * @param giveTitleName
     * @param offlinePlayer
     */
    @CommandPermission("admin.bum.else_bum")
    @Subcommand("give")
    @CommandCompletion("@players")
    @Description("유저에게 칭호를 부여할 수 있습니다.")
    public void make(@NotNull CommandSender sender, String giveTitleName, OfflinePlayer offlinePlayer) {

        if (!(sender instanceof Player)) return;
        Player player = (Player) sender;

        if (giveTitleName.length() == 0) {
            player.sendMessage(StringUtil.format("부여할 칭호의 이름을 적으시오.</b>"));
            return;
        }
        if (!(offlinePlayer.isOnline() || offlinePlayer == null)) {
            player.sendMessage(offlinePlayer.getName() + " 님은 오프라인 이거나 존재하지 않습니다.</b>");
            return;
        }

        TitleFile titleFile = new TitleFile(player);
        TitleFile titleFile1 = new TitleFile(offlinePlayer.getPlayer());

        if (!(titleFile.getTitle().contains(giveTitleName))) {
            player.sendMessage("[" + giveTitleName + "]" + " (이)라는 칭호는 존재하지 않습니다.");
            return;
        }
        if (titleFile1.getTitle().contains(giveTitleName)) {
            player.sendMessage(offlinePlayer.getName() + " 님은 이미" + "[" + giveTitleName + "]" + " 칭호를 갖고 있습니다");
            return;
        }

        titleFile1.addTitle(giveTitleName);
        titleFile1.addPersonalTitle(giveTitleName);
        titleFile1.save();

        player.sendMessage(offlinePlayer.getName() + " 님에게 " + "[" + giveTitleName + "]" + " 칭호를 부여했습니다.");





    }
}
