package com.sam.graduation.design.gdmusicserver.utils.music;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

import java.nio.file.Paths;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/11 16:53:43
 */
public class MusicUtil {

    /**
     * 获取MP3播放时长的方法
     * @param src 存储MP3的路径
     * @return 返回播放时长
     */
    public static int getMusicDuration(String src) {
        int length = 0;
        try {
            MP3File mp3File = (MP3File) AudioFileIO.read(Paths.get(src).toFile());
            MP3AudioHeader audioHeader = (MP3AudioHeader) mp3File.getAudioHeader();

            // 单位为秒
            length = audioHeader.getTrackLength();

            return length;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return length;
    }

}
