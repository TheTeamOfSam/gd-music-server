package com.sam.graduation.design.gdmusicserver.service.music.impl;

import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;
import com.sam.graduation.design.gdmusicserver.dao.MusicMapper;
import com.sam.graduation.design.gdmusicserver.model.pojo.Music;
import com.sam.graduation.design.gdmusicserver.service.base.BaseService;
import com.sam.graduation.design.gdmusicserver.service.music.MusicService;
import com.sam.graduation.design.gdmusicserver.utils.music.MusicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/11 16:45:11
 */
@Service
public class MusicServiceImpl extends BaseService implements MusicService {

    private static final String FILE_SEPARATOR = File.separator;

    @Autowired
    private MusicMapper musicMapper;

    @Value("${music.root.path}")
    private String musicRootPath;

    @Override
    public MessageDto oneBtnToUpdateDuration() {
        MessageDto messageDto = null;
        List<Music> music = this.musicMapper.selectAllMusic();

        List<Music> mscUdPo = new ArrayList<Music>();
        for (Music msc : music) {
            int mscDuration = MusicUtil.getMusicDuration(musicRootPath + FILE_SEPARATOR + msc.getMusicPath());
            msc.setLastModifiedTime(new Date());
            msc.setMusicDuration(mscDuration);
            mscUdPo.add(msc);
        }

        List<Integer> integers = new ArrayList<Integer>();
        for (Music msc : mscUdPo) {
            int updateResult = this.musicMapper.updateByPrimaryKeySelective(msc);
            integers.add(updateResult);
        }

        for (Integer integer: integers) {
            if (integer==0) {
                messageDto = new MessageDto();
                messageDto.setSuccess(false);
                messageDto.setMessage("一键更新音乐播放时长失败");
                return messageDto;
            }
        }
        messageDto = new MessageDto();
        messageDto.setMessage("一键更新音乐播放时长成功");
        messageDto.setSuccess(true);
        return messageDto;
    }
}
