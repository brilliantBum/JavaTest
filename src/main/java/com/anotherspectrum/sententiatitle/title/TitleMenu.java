package com.anotherspectrum.sententiatitle.title;

import com.anotherspectrum.anotherlibrary.menu.ItemCreator;
import com.anotherspectrum.anotherlibrary.menu.MenuManager;
import com.anotherspectrum.anotherlibrary.utils.StringUtil;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class TitleMenu extends MenuManager {

    private final Material book = Material.BOOK;

    public TitleMenu() {
        super(3, "<b>[TitleList]", true);

        setItem(12, ItemCreator.create(book,1, StringUtil.format("<b><gray>나의 칭호</b>"),
                StringUtil.ellipsis("내가 얻은 칭호를 확인할 수 있습니다."),true), (player, inventoryClickEvent) -> {
            new MyTitleMenu().open(player);

        });

        setItem(14, ItemCreator.create(book, 1, StringUtil.format("<b><gray>전체 칭호 목록</b>"),
                StringUtil.ellipsis("전체 칭호 목록을 확인할 수 있습니다."), true), (player, inventoryClickEvent) -> {
            new AllTitleMenu().open(player);

        });

    }
}
