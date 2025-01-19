<template>
  <section class="recommendation-container">
    <h1>Recomandările Tale</h1>
    <p>Pe baza răspunsurilor tale la quiz, iată trei obiceiuri care te-ar putea ajuta:</p>
    <div class="habits-list">
      <div
        v-for="(habit, index) in habits"
        :key="index"
        class="habit-card"
        :class="{ selected: selectedHabit === habit }"
        @mouseover="hoverHabit = index"
        @mouseleave="hoverHabit = null"
      >
        <h2>{{ habit }}</h2> <!-- Only the habit title is displayed -->
        <!-- Hidden Buttons -->
        <div v-if="hoverHabit === index" class="buttons">
          <button @click="selectHabit(habit, index)">Alege</button>
        </div>
      </div>
    </div>
  </section>
</template>



<script setup>
import { ref, onMounted } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";

const habits = ref([]); // Holds the recommendations
const hoverHabit = ref(null); // Tracks the hovered habit for showing buttons
const selectedHabit = ref(null); // Tracks the selected habit
const router = useRouter(); // For navigation

// Fetch habits from the backend
async function fetchHabits() {
  try {
    const response = await axios.get("http://localhost:8080/recommendation");
    habits.value = response.data.map((habit) => habit.title); // Extract only the title from the response
  } catch (error) {
    console.error("Eroare la preluarea recomandărilor:", error);
  }
}

async function selectHabit(habit) {
try {
  // Extract the habit title (assuming habit is an object with a title field)
  const habitTitle =habit;
  console.log(habitTitle)

  //selectedHabit.value = habitTitle; // Mark the selected habit

  // Send the habit title to the backend
  const response = await axios.post("http://localhost:8080/recommandation", {
    title: habitTitle,
  });

  console.log("Response from backend:", response.data);

  // Navigate to the calendar route with the selected habit as a query parameter
  router.push({ path: "/calendar", query: { habit: habitTitle } });
} catch (error) {
  console.error("Eroare la trimiterea obiceiului selectat:", error.response || error);
  alert("A apărut o eroare la trimiterea obiceiului selectat.");
}
}

// Fetch habits on component mount
onMounted(() => {
  fetchHabits();
});
</script>


<style scoped>
.recommendation-container {
max-width: 800px;
margin: 50px auto;
padding: 20px;
font-family: "Arial", sans-serif;
background-color: #fff;
border-radius: 12px;
box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
text-align: center;
}

h1 {
font-size: 28px;
margin-bottom: 20px;
color: #094e21;
}

.habits-list {
display: grid;
grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
gap: 20px;
margin-top: 30px;
}

.habit-card {
background: linear-gradient(145deg, rgba(175, 226, 171, 0.2), rgba(83, 136, 56, 0.2));
border-radius: 12px;
padding: 20px;
text-align: left;
color: #333;
box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
position: relative;
cursor: pointer;
transition: transform 0.2s, background-color 0.3s;
}

.habit-card:hover {
transform: scale(1.05);
background-color: rgba(175, 226, 171, 0.4);
}

/* Highlight selected habit */
.habit-card.selected {
background-color: rgba(83, 136, 56, 0.4);
border: 2px solid #007bff;
}

/* Buttons for Habit Card */
.buttons {
position: absolute;
bottom: 10%;
left: 50%;
transform: translateX(-50%);
display: flex;
gap: 10px;
}

.buttons button {
padding: 6px 12px;
font-size: 14px;
border: none;
border-radius: 4px;
cursor: pointer;
color: white;
background-color: #007bff;
transition: background-color 0.3s;
}

.buttons button:hover {
background-color: #0056b3;
}
</style>