package org.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentRole {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String displayName;
        private String description;
        private String displayIcon;
        private String assetPath;

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

        public String getDisplayIcon() {
                return displayIcon;
        }

        public void setDisplayIcon(String displayIcon) {
                this.displayIcon = displayIcon;
        }

        public String getAssetPath() {
                return assetPath;
        }

        public void setAssetPath(String assetPath) {
                this.assetPath = assetPath;
        }
}
