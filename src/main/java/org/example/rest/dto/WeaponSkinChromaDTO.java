package org.example.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeaponSkinChromaDTO {
    private Long id;
    private String displayName;
    private String displayIcon;
    private String fullRender;
    private String swatch;
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

    public String getDisplayIcon() {
        return displayIcon;
    }

    public void setDisplayIcon(String displayIcon) {
        this.displayIcon = displayIcon;
    }

    public String getFullRender() {
        return fullRender;
    }

    public void setFullRender(String fullRender) {
        this.fullRender = fullRender;
    }

    public String getSwatch() {
        return swatch;
    }

    public void setSwatch(String swatch) {
        this.swatch = swatch;
    }

    public String getStreamedVideo() {
        return streamedVideo;
    }

    public void setStreamedVideo(String streamedVideo) {
        this.streamedVideo = streamedVideo;
    }
}