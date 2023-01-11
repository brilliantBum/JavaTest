package com.anotherspectrum.sententiatitle.title;

import com.anotherspectrum.anotherlibrary.files.FileManager;
import com.anotherspectrum.sententiatitle.commands.TitleCommands;
import lombok.Getter;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TitleFile extends FileManager {

    private @Getter Player player;
    private @Getter OfflinePlayer offlinePlayer;

    public TitleFile(Player player) {
        super(player, "title_data.yml");

        this.player = player;
        this.offlinePlayer = getOfflinePlayer();

        isNotContains("title", () -> {

            getConfig().set("title.list", new ArrayList<>()); // 모든 칭호를 저장.
            getConfig().set("title.personal_list", new ArrayList<>()); //플레이어가 얻은 칭호를 저장.
            save();
        });
    }

    // GETTER

    /**
     * 칭호 데이터 파일에서 칭호 list를 불러옴
     * @return
     */
    public List<String> getTitle() {
        return getConfig().getStringList("title.list");
    }

    /**
     * 플레이어가 얻은 칭호 파일에서 칭호 list를 불러옴
     * @return
     */

    public List<String> getPersonalList() {
        return getConfig().getStringList("title.personal_list");
    }

    /**
     * 배열 형태의 전체 칭호 목록 파일에 추가함
     * @return
     */
    public void addTitle(String titleName) {
        String path = "title.list";
        List<String> list = getConfig().getStringList(path);
        list.add(titleName);
        getConfig().set(path, list);
        save();
    }

    /**
     * 배열 형태의 개인 칭호 목록 파일에 추가함
     */
    public void addPersonalTitle(String giveTitleName) {
        String path = "title.personal_list";
        List<String> list = getConfig().getStringList(path);
        list.add(giveTitleName);
        getConfig().set(path, list);
        save();
    }



    /**
     * 배열 형태의 얻은 칭호 목록 파일에서 삭제함
     *//*
    public List removeList() {
        List<String> list = getConfig().getStringList("title.list");
        list.remove()
    }*/




}
