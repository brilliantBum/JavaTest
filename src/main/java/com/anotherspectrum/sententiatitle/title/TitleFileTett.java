package com.anotherspectrum.sententiatitle.title;

import com.anotherspectrum.anotherlibrary.files.FileManager;
import lombok.Getter;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TitleFileTett extends FileManager {

    public TitleFileTett() {
        super("titles", "titles.yml");

        isNotContains("titles", () -> {
            getConfig().set("titles", new ArrayList<>()); // 모든 칭호를 저장.
            save();
        });

    }

    // GETTER

    /**
     * 칭호 데이터 파일에서 칭호 list를 불러옴
     * @return
     */
    public List<String> getTitle() {
        return getConfig().getStringList("titles");
    }


    /**
     * 배열 형태의 전체 칭호 목록 파일에 추가함
     * @return
     */
    public void addTitle(String titleName) {
        String path = "titles";
        List<String> list = getConfig().getStringList(path);
        list.add(titleName);
        getConfig().set(path, list);
        save();
    }

}
