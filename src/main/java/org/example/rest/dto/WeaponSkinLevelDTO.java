package org.example.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeaponSkinLevelDTO {
    private Long id;
    private String displayName;
    private String levelItem;
    private String displayIcon;
    private String streamedVideo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLevelItem() {
        return levelItem;
    }

    public void setLevelItem(String levelItem) {
        this.levelItem = levelItem;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    public void setDisplayIcon(String displayIcon) {
        this.displayIcon = displayIcon;
    }

    public String getStreamedVideo() {
        return streamedVideo;
    }

    public void setStreamedVideo(String streamedVideo) {
        this.streamedVideo = streamedVideo;
    }
}