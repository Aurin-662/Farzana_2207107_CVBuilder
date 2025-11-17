📄 CV Builder – JavaFX Project
A simple and elegant JavaFX application that allows users to create and preview a professional CV. Built with Java, FXML, and SceneBuilder, this project demonstrates modular design, clean UI layout, and dynamic scene switching.


🚀 Features
-  Form Input: Collects user details like name, contact, education, skills, projects, experience, and a short bio
-  Image Upload: Allows users to upload a profile picture
-  Validation Alerts: Warns if any field is left empty or mobile number is invalid
-  Confirmation Dialog: Asks for confirmation before generating the CV
-  Preview Page: Displays a formatted CV with all entered information and profile image
-  Clean UI: Designed using SceneBuilder with proper padding, spacing, and visual hierarchy


🧪 How to Run
- Open the project in IntelliJ IDEA (or any Java IDE)
- Ensure JavaFX SDK is properly configured
- Run HelloApplication.java
- Fill out the form → Upload image → Click Generate
- Confirm to preview your CV


⚠️ Input Validation
- All fields are mandatory
- Mobile number must be exactly 11 digits
- If any field is empty or invalid, a warning alert will appear


📂 Project Structure
cv107/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/cv107/
│       │       ├── HelloApplication.java     # Main launcher class
│       │       ├── formcontroller.java       # Handles form input, validation, and preview logic
│       │       ├── previewcontroller.java    # Displays CV preview with user data
│       │       ├── homecontroller.java       # Handles welcome screen logic
│       │       └── Launcher.java             # Alternate entry point or setup class
│       ├── resources/
│       │   └── com/example/cv107/
│       │       ├── hello-view.fxml           # Welcome screen layout
│       │       ├── form.fxml                 # CV input form layout
│       │       ├── preview.fxml              # CV preview layout
│       │       └── style.css                 # Custom styling for UI components
│       └── module-info.java                  # Java module declaration


