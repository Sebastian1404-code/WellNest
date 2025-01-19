<template>
    <div class="login-container">
      <h1>Log In</h1>
      <form @submit.prevent="handleLogin">
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
          <label for="password">Password</label>
          <input
            type="password"
            id="password"
            v-model="password"
            placeholder="Enter your password"
            required
          />
        </div>
        <button type="submit">Log In</button>
      </form>
      <p v-if="errorMessage" class="error-message">{{ errorMessage }}</p>
  
      <!-- Link către pagina de înregistrare -->
      <div class="create-account">
        <p>Don't have an account?</p>
        <RouterLink to="/createAccount">Create Account</RouterLink>
      </div>
      
    </div>
  </template>
  
  <script setup>
  import { ref } from "vue";
  import { useRouter } from "vue-router";
  import axios from "axios";
  
  const nickname = ref("");
  const password = ref("");
  const errorMessage = ref("");
  const router = useRouter();
  
  async function handleLogin() {
    try {
      const response = await axios.post("http://localhost:8080/api/users/login", {
        nickname: nickname.value,
        password: password.value,
      });
  
      if (response.data===true) {
        console.log(response.data)
        console.log("Login successful");
        localStorage.setItem("isLoggedIn", "true");
        localStorage.setItem("nickname", nickname.value);

        // Navighează la pagina de Home
        router.push("/");
      } else {
        // Afișează un mesaj de eroare
        errorMessage.value = "Invalid nickname or password.";
      }
    } catch (error) {
      // Gestionează erorile
      errorMessage.value = "An error occurred. Please try again later.";
      console.error("Error:", error);

    }
  }
  </script>
  
  <style scoped>
/* Page Background with Image */
body {
  background: url('@/components/pngs/loginbg.png') ; /* Add background image */
  background-size: cover; /* Ensure the image covers the whole page */
  margin: 0;
  font-family: 'Arial', sans-serif;
}

/* Login Container */
.login-container {
  max-width: 400px;
  margin: 50px auto;
  padding: 20px;
  background-color: white; /* Keep the container white */
  border: 1px solid rgba(0, 0, 0, 0.1);
  border-radius: 12px;
  text-align: center;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
}

/* Heading */
h1 {
  margin-bottom: 20px;
  font-size: 28px;
  color: #094e21; /* Pink */
  font-family: 'Arial', sans-serif;
  font-weight: bold;
}

/* Form Group */
.form-group {
  margin-bottom: 15px;
  text-align: left;
}

label {
  font-size: 14px;
  font-weight: bold;
  color: #333;
}

input {
  width: 100%;
  padding: 10px;
  margin-top: 5px;
  border: 1px solid #ccc;
  border-radius: 6px;
  font-size: 14px;
}

/* Button Styles */
button {
  width: 100%;
  padding: 10px;
  background: linear-gradient(90deg, #afe2ab, #538838); /* Light Green Gradient */
  color: white;
  border: none;
  border-radius: 6px;
  font-size: 16px;
  font-weight: bold;
  cursor: pointer;
  transition: all 0.3s ease-in-out;
}

button:hover {
    background: linear-gradient(90deg, #afe2ab, #538838); /* Light Green Gradient */
    box-shadow: 0 4px 10px rgba(15, 85, 22, 0.5);
}

/* Error Message */
.error-message {
  margin-top: 10px;
  color: #08541e;
  font-size: 14px;
  font-weight: bold;
}

/* Create Account Section */
.create-account {
  margin-top: 20px;
}

.create-account p {
  margin: 0;
  font-size: 14px;
  color: #555;
}

.create-account a {
  color: #53c69d;
  text-decoration: none;
  font-weight: bold;
}

.create-account a:hover {
  text-decoration: underline;
  color: #95eda4; /* Yellow on hover */
}

/* Responsive Design */
@media (max-width: 768px) {
  .login-container {
    margin: 20px;
    padding: 15px;
  }

  h1 {
    font-size: 24px;
  }

  button {
    font-size: 14px;
  }

  input {
    font-size: 12px;
  }
}
</style>

  