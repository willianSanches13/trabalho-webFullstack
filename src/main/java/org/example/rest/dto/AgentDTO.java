package org.example.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentDTO {
    private Long id;
    @NotBlank
    private String displayName;
    @Size(max = 255, message = "Description cannot exceed 255 characters")
    private String description;
    private String developerName;
    private List<String> characterTags;
    private String displayIcon;
    private String bustPortrait;
    private String fullPortrait;
    private String file;
    private String assetPath;
    private boolean isFullPortraitRightFacing;
    private boolean isPlayableCharacter;
    private boolean isAvailableForTest;
    private AgentRoleDTO role;
    private List<AgentAbilityDTO> abilities;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public List<String> getCharacterTags() {
        return characterTags;
    }

    public void setCharacterTags(List<String> characterTags) {
        this.characterTags = characterTags;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    public void setDisplayIcon(String displayIcon) {
        this.displayIcon = displayIcon;
    }

    public String getBustPortrait() {
        return bustPortrait;
    }

    public void setBustPortrait(String bustPortrait) {
        this.bustPortrait = bustPortrait;
    }

    public String getFullPortrait() {
        return fullPortrait;
    }

    public void setFullPortrait(String fullPortrait) {
        this.fullPortrait = fullPortrait;
    }

    public String getAssetPath() {
        return assetPath;
    }

    public void setAssetPath(String assetPath) {
        this.assetPath = assetPath;
    }

    public boolean isFullPortraitRightFacing() {
        return isFullPortraitRightFacing;
    }

    public void setFullPortraitRightFacing(boolean fullPortraitRightFacing) {
        isFullPortraitRightFacing = fullPortraitRightFacing;
    }

    public boolean isPlayableCharacter() {
        return isPlayableCharacter;
    }

    public void setPlayableCharacter(boolean playableCharacter) {
        isPlayableCharacter = playableCharacter;
    }

    public boolean isAvailableForTest() {
        return isAvailableForTest;
    }

    public void setAvailableForTest(boolean availableForTest) {
        isAvailableForTest = availableForTest;
    }

    public AgentRoleDTO getRole() {
        return role;
    }

    public void setRole(AgentRoleDTO role) {
        this.role = role;
    }

    public List<AgentAbilityDTO> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AgentAbilityDTO> abilities) {
        this.abilities = abilities;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}