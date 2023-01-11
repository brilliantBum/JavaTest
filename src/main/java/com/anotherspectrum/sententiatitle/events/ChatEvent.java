package com.anotherspectrum.sententiatitle.events;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {

    private String PREFIX = "[칭호]";

//    TitleCommands t = new TitleCommands();

    @EventHandler
    public void chat(AsyncChatEvent event) {
        Player player = event.getPlayer();

        /*if (player.)*/



        // 아래 코드는 플레이어가 채팅 입력 시 player 에게는 "메세지" + "테스트" 가 출력되고 audience 들에게 "테스트"가 출력된다.
        // [새싹]을 파일에서 플레이어가 클릭한 타이틀로 변경해야함.

        TextComponent t = Component.text("[새싹]", NamedTextColor.GREEN, TextDecoration.BOLD);

        event.message(t);






        /*event.message(Component.text(PREFIX).content());*/


    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {



    }
}
