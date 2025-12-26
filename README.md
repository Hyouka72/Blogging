📝 Blogging Platform
A full-stack blogging application built with Java (Spring Boot) on the backend and React + Vite on the frontend. This project allows users to create, view, and manage blog posts with category filtering and user profiles.
🚀 Features
- 🧑‍💻 User authentication and profile management
- 📝 Create, edit, delete blog posts
- 📂 Categorize posts for better organization
- 🔍 View detailed post pages
- 📃 List all posts with pagination
- ⚙️ RESTful API integration between frontend and backend

🧱 Tech Stack
- Frontend: React, Vite, Axios
- Backend: Spring Boot, Spring Security, JWT
- Database: PostgreSQL
- Build Tool: Maven
- Version Control: Git & GitHub


📁 Project Structure
Backend (/)
- src/main/java/... – Spring Boot source code
- pom.xml – Maven build file
Frontend (/blogFrontend)
- src/pages/ – React pages like Posts, CreatePost, PostDetails, etc.
- src/router/router.jsx – React Router configuration
- vite.config.js – Vite setup
⚙️ Setup Instructions
Backend
# Navigate to backend root
cd Blogging

# Build and run
./mvnw spring-boot:run


Frontend
# Navigate to frontend
cd blogFrontend

# Install dependencies
npm install

# Run development server
npm run dev


🛠️ Known Issues
- 🔧 CreatePost.jsx import error: Ensure the file exists in src/pages/ and matches the import path exactly.
- 🧪 No test coverage yet — contributions welcome!
📌 TODO
- Add user registration flow
- Implement post editing
- Improve UI/UX with Tailwind or Material UI
- Add unit and integration tests
🤝 Contributing
Pull requests are welcome! For major changes, please open an issue first to discuss what you'd like to change.
