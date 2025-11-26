package org.example.cv107;

public class cvModel {
    private Integer id;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String education;
    private String projects;
    private String skills;
    private String workExperience;
    private String photoPath;
    private String createdAt;
    private String updatedAt;

    // ✅ Default constructor (needed for ResultSet extraction)
    public cvModel() {}

    // ✅ Constructor for new CVs (no ID yet)
    public cvModel(String fullName, String email, String phone, String address,
                   String education, String projects, String skills,
                   String workExperience, String photoPath, String idText) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.education = education;
        this.projects = projects;
        this.skills = skills;
        this.workExperience = workExperience;
        this.photoPath = photoPath;

        // Convert idText to Integer if provided
        if (idText != null && !idText.isBlank()) {
            try {
                this.id = Integer.parseInt(idText);
            } catch (NumberFormatException e) {
                this.id = null; // fallback if invalid
            }
        }
    }

    // ✅ Constructor for existing CVs (with ID)
    public cvModel(Integer id, String fullName, String email, String phone, String address,
                   String education, String projects, String skills,
                   String workExperience, String photoPath) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.education = education;
        this.projects = projects;
        this.skills = skills;
        this.workExperience = workExperience;
        this.photoPath = photoPath;
    }

    // ✅ Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }

    public String getProjects() { return projects; }
    public void setProjects(String projects) { this.projects = projects; }

    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }

    public String getWorkExperience() { return workExperience; }
    public void setWorkExperience(String workExperience) { this.workExperience = workExperience; }

    public String getPhotoPath() { return photoPath; }
    public void setPhotoPath(String photoPath) { this.photoPath = photoPath; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}