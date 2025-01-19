<template>
    <div class="quiz-container">
      <h1>Interactive Quiz</h1>
      <form @submit.prevent="submitQuiz">
        <div v-for="(question, index) in questions" :key="index" class="question">
          <p class="question-title">{{ question.question }}</p>
          <div class="options">
            <label
              v-for="(option, optIndex) in question.options"
              :key="optIndex"
              class="option"
            >
              <input
                type="radio"
                :name="'question-' + index"
                :value="optIndex"
                v-model="answers[index]"
              />
              <span>{{ option }}</span>
            </label>
          </div>
        </div>
        <button type="submit" class="submit-btn" @click.prevent="submitQuiz">Submit Answers</button>
    </form>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from "vue";
  import { useRouter } from "vue-router"; // Import Vue Router
  import axios from "axios";
  
  const questions = ref([]);
  const answers = ref([]);
  const router = useRouter(); // Initialize router
  
  // Convert index to letter (0 -> a, 1 -> b, 2 -> c, etc.)
  function indexToLetter(index) {
    return String.fromCharCode(97 + index); // 97 is the ASCII code for 'a'
  }
  
  // Fetch questions from the backend
  async function fetchQuestions() {
    try {
      const response = await axios.get("http://localhost:8080/quiz");
      questions.value = response.data;
      answers.value = Array(questions.value.length).fill(null);
    } catch (error) {
      console.error("Error fetching questions:", error);
    }
  }
  
  // Submit answers to the backend
  async function submitQuiz() {
    if (answers.value.includes(null)) {
      alert("Please answer all questions.");
      return;
    }
  
    // Map selected indices to letters
    const formattedAnswers = answers.value.map((index) => indexToLetter(index));
  
    try {
      const response = await axios.post("http://localhost:8080/quiz/ai", formattedAnswers);
      // Navigate to the recommendations page
      console.log("should route");
      
      router.push({
        path: "/recommendation",
        query: { result: response.data }, // Optionally pass quiz results as query parameters
      });
    } catch (error) {
      console.error("Error submitting answers:", error);
    }
  }
  
  onMounted(fetchQuestions);
  </script>
  
  <style scoped>
  /* Styles remain unchanged */
  .quiz-container {
    max-width: 600px;
    margin: 50px auto;
    padding: 20px;
    border-radius: 12px;
    background-color: #ffffff;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    font-family: "Arial", sans-serif;
    color: #333;
  }
  
  h1 {
    text-align: center;
    font-size: 28px;
    margin-bottom: 20px;
  }
  
  .question {
    margin-bottom: 20px;
  }
  
  .question-title {
    font-size: 18px;
    font-weight: bold;
    margin-bottom: 10px;
  }
  
  .options {
    display: flex;
    flex-direction: column;
  }
  
  .option {
    margin-bottom: 10px;
    font-size: 16px;
    display: flex;
    align-items: center;
    gap: 10px;
  }
  
  input[type="radio"] {
    transform: scale(1.2);
    cursor: pointer;
  }
  
  .submit-btn {
    display: block;
    margin: 20px auto;
    padding: 12px 20px;
    font-size: 18px;
    font-weight: bold;
    color: white;
    background-color: #007bff;
    border: none;
    border-radius: 6px;
    cursor: pointer;
    transition: background-color 0.3s, transform 0.2s;
  }
  
  .submit-btn:hover {
    background-color: #0056b3;
    transform: translateY(-2px);
  }
  
  .submit-btn:active {
    background-color: #003f7f;
    transform: translateY(0);
  }
  </style>
  