package org.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String displayName;
    private String description;
    private String developerName;
    @ElementCollection
    private List<String> characterTags;
    private String displayIcon;
    private String bustPortrait;
    private String fullPortrait;
    private String assetPath;
    private boolean isFullPortraitRightFacing;
    private boolean isPlayableCharacter;
    private boolean isAvailableForTest;

    @ManyToOne(cascade = CascadeType.ALL)
    private AgentRole role;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AgentAbility> abilities;

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

    public AgentRole getRole() {
        return role;
    }

    public void setRole(AgentRole role) {
        this.role = role;
    }

    public List<AgentAbility> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AgentAbility> abilities) {
        this.abilities = abilities;
    }
}
