<template>
    <div class="page-container">
      <div class="register-container">
        <h1>Create Account</h1>
        <form @submit.prevent="handleRegister">
          <div class="form-group">
            <label for="nickname">Nickname</label>
            <input
              type="text"
              id="nickname"
              v-model="nickname"
              placeholder="Enter your nickname"
              required
            />
          </div>
          <div class="form-group">
            <label for="firstName">First Name</label>
            <input
              type="text"
              id="firstName"
              v-model="firstName"
              placeholder="Enter your first name"
              required
            />
          </div>
          <div class="form-group">
            <label for="lastName">Last Name</label>
            <input
              type="text"
              id="lastName"
              v-model="lastName"
              placeholder="Enter your last name"
              required
            />
          </div>
          <div class="form-group">
            <label for="email">Email</label>
            <input
              type="email"
              id="email"
              v-model="email"
              placeholder="Enter your email"
              required
            />
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input
              type="password"
              id="password"
              v-model="password"
              placeholder="Enter your password"
              required
            />
          </div>
          <button type="submit">Register</button>
        </form>
        <p v-if="successMessage" class="success-message">{{ successMessage }}</p>
        <p v-if="errorMessage" class="error-message">{{ errorMessage }}</p>
      </div>
    </div>
  </template>
  
  <script setup>
import { ref } from "vue";
import { useRouter } from "vue-router"; // Importă useRouter
import axios from "axios";

const nickname = ref("");
const firstName = ref("");
const lastName = ref("");
const email = ref("");
const password = ref("");
const successMessage = ref("");
const errorMessage = ref("");

// Inițializează router-ul
const router = useRouter();

async function handleRegister() {
  try {
    const response = await axios.post("http://localhost:8080/api/users/register", {
      nickname: nickname.value,
      firstName: firstName.value,
      lastName: lastName.value,
      email: email.value,
      password: password.value,
    });

    if (response.data) {
      successMessage.value = "Account created successfully!";
      errorMessage.value = "";
      clearForm();
      // Navighează la pagina Quiz
      router.push("/quiz");
    } else {
      errorMessage.value = "Registration failed. Nickname might be taken.";
      successMessage.value = "";
    }
  } catch (error) {
    errorMessage.value = "An error occurred. Please try again later.";
    successMessage.value = "";
    console.error("Error:", error);
  }
}

  
  function clearForm() {
    nickname.value = "";
    firstName.value = "";
    lastName.value = "";
    email.value = "";
    password.value = "";
  }
  </script>
  
  <style scoped>
  /* General Page Background */

  .page-container {
  display: flex; /* Activează Flexbox */
  justify-content: center; /* Centrează pe orizontală */
  align-items: center; /* Centrează pe verticală */
  min-height: 100vh; /* Întindere completă pe înălțime */
  background: url('@/components/pngs/loginbg.png') no-repeat center center fixed; /* Imagine fundal */
  background-size: cover; /* Fundal adaptat */
}

/* Register Container */
.register-container {
  max-width: 400px;
  width: 100%;
  padding: 30px;
  border-radius: 12px;
  background-color: white; /* Fundal alb */
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2); /* Umbră */
  text-align: center;
}


  body {
    margin: 0;
    padding: 0;
    display: flex; /* Enables Flexbox */
    justify-content: center; /* Centers horizontally */
    align-items: center; /* Centers vertically */
    min-height: 100vh; /* Ensures full-page height */
    background: url('@/components/pngs/loginbg.png') no-repeat center center fixed; /* Background image */
    background-size: cover; /* Ensures the image covers the full page */
  }
  
  
  /* Register Container */
  .register-container {
    max-width: 400px;
    width: 100%;
    margin: 20px;
    padding: 30px;
    border-radius: 12px;
    background-color: white; /* Keep container white */
    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
    text-align: center;
  }
  
  /* Heading */
  h1 {
    margin-bottom: 20px;
    font-size: 28px;
    color: #174616; /* Pink */
    font-weight: bold;
  }
  
  /* Form Group */
  .form-group {
    margin-bottom: 20px;
    text-align: left;
  }
  
  label {
    display: block;
    margin-bottom: 8px;
    font-weight: bold;
    color: #555;
    font-size: 14px;
  }
  
  input {
    width: 100%;
    padding: 12px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 6px;
    background-color: #fff;
    transition: border-color 0.3s, box-shadow 0.3s;
  }
  
  input:focus {
    border-color: #0d6d24; /* Pink focus color */
    box-shadow: 0 0 5px rgba(27, 91, 26, 0.5);
  }
  
  input:hover {
    border-color: #6fff59; /* Yellow hover color */
  }
  
  /* Button Styles */
  button {
    width: 100%;
    padding: 12px;
    font-size: 16px;
    font-weight: bold;
    color: white;
    background: linear-gradient(90deg, #afe2ab, #538838); /* Light Green Gradient */
    border: none;
    border-radius: 6px;
    cursor: pointer;
    transition: all 0.3s ease-in-out;
  }
  
  button:hover {
    background: linear-gradient(90deg, #afe2ab, #538838); /* Light Green Gradient */
    box-shadow: 0 4px 10px rgba(45, 111, 62, 0.5);
    transform: translateY(-2px);
  }
  
  button:active {
    transform: translateY(0);
  }
  
  /* Success and Error Messages */
  .success-message,
  .error-message {
    margin-top: 20px;
    font-size: 14px;
    font-weight: bold;
  }
  
  .success-message {
    color: #28a745;
  }
  
  .error-message {
    color: #0c4922;
  }
  
  /* Responsive Design for Mobile */
  @media (max-width: 480px) {
    .register-container {
      padding: 20px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }
  
    h1 {
      font-size: 24px;
    }
  
    input {
      font-size: 14px;
      padding: 10px;
    }
  
    button {
      padding: 10px;
      font-size: 14px;
    }
  }
  </style>
  