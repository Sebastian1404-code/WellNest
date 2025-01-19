<template>
    <div class="calendar-wrapper">
      <!-- Motivational Quotes - Left -->
      <div class="quotes left">
        <p v-for="(quote, index) in leftQuotes" :key="'left-' + index" class="quote">
          {{ quote }}
        </p>
      </div>
  
      <!-- Calendar -->
      <div class="calendar-container">
        <h2 class="calendar-title">Monthly Habit Tracker</h2>
        <div class="month-navigation">
          <button class="nav-button" @click="prevMonth">❮</button>
          <h3 class="month">{{ currentMonthName }} {{ currentYear }}</h3>
          <button class="nav-button" @click="nextMonth">❯</button>
        </div>
        <div class="calendar-grid">
          <!-- Header for days of the week -->
          <div v-for="(day, index) in daysOfWeek" :key="index" class="day-header">
            {{ day }}
          </div>
  
          <!-- Days of the month -->
          <div
            v-for="(day, index) in calendarDays"
            :key="index"
            class="day-cell"
            :class="day.status"
            @mouseover="hoverDate = index"
            @mouseleave="hoverDate = null"
          >
            <span v-if="day.date" class="date-number">{{ day.date }}</span>
            <!-- Hidden buttons -->
            <div v-if="hoverDate === index && day.date" class="buttons">
              <button @click="markAsDone(index)">✔️</button>
              <button @click="markAsInvalid(index)">❌</button>
            </div>
          </div>
        </div>
      </div>
  
      <!-- Motivational Quotes - Right -->
      <div class="quotes right">
        <p v-for="(quote, index) in rightQuotes" :key="'right-' + index" class="quote">
          {{ quote }}
        </p>
      </div>
    </div>
  </template>
  
  
  <script setup>
  import { ref, computed } from "vue";
  import dayjs from "dayjs";
  import axios from "axios";
  
  // Motivational Quotes
  const quotes = [
    "A little progress each day adds up to big results.",
    "Don't watch the clock; do what it does. Keep going.",
    "You don't have to be perfect to make progress.",
    "Discipline is the bridge between goals and accomplishment.",
    "Small steps every day lead to big changes.",
    "Push yourself because no one else is going to do it for you.",
    "Habit is what keeps you going when motivation runs out.",
  ];
  
  // Split quotes into left and right arrays
  const leftQuotes = quotes.slice(0, Math.ceil(quotes.length / 2));
  const rightQuotes = quotes.slice(Math.ceil(quotes.length / 2));
  
  // Calendar setup
  const daysOfWeek = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"];
  const hoverDate = ref(null);
  
  const currentYear = ref(dayjs().year());
  const currentMonth = ref(dayjs().month()); // Zero-based (0 = January, 11 = December)
  
  const currentMonthName = computed(() =>
    dayjs().month(currentMonth.value).format("MMMM")
  );
  
  const calendarDays = computed(() => {
    const daysInMonth = dayjs()
      .year(currentYear.value)
      .month(currentMonth.value)
      .daysInMonth();
    const firstDayOfMonth = dayjs()
      .year(currentYear.value)
      .month(currentMonth.value)
      .date(1)
      .day();
  
    const emptyDays = (firstDayOfMonth + 6) % 7;
    const days = Array(emptyDays)
      .fill({ date: null, status: "empty" })
      .concat(
        Array.from({ length: daysInMonth }, (_, index) => ({
          date: index + 1,
          status: "not-entered",
        }))
      );
    return days;
  });
  
  async function markAsDone(index) {
    if (calendarDays.value[index]?.date) {
      calendarDays.value[index].status = "in-progress";
      await syncWithBackend();
    }
  }
  
  async function markAsInvalid(index) {
    if (calendarDays.value[index]?.date) {
      calendarDays.value[index].status = "invalid";
      await syncWithBackend();
    }
  }
  
  async function syncWithBackend() {
    const stateVector = calendarDays.value.map((day) => {
      if (day.status === "done") return 2;
      if (day.status === "in-progress") return 1;
      if (day.status === "invalid") return 0;
      return -1;
    });
  
    try {
      const response = await axios.post(
        "http://localhost:8080/api/leaderboard/score",
        stateVector
      );
      console.log("Sync successful:", response.data);
    } catch (error) {
      console.error("Sync failed:", error);
    }
  }
  
  function prevMonth() {
    if (currentMonth.value === 0) {
      currentMonth.value = 11;
      currentYear.value -= 1;
    } else {
      currentMonth.value -= 1;
    }
    syncWithBackend();
  }
  
  function nextMonth() {
    if (currentMonth.value === 11) {
      currentMonth.value = 0;
      currentYear.value += 1;
    } else {
      currentMonth.value += 1;
    }
    syncWithBackend();
  }
  </script>
  

  <style scoped>
  /* Wrapper for the calendar and quotes */
  .calendar-wrapper {
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    gap: 20px;
    max-width: 1000px;
    margin: 0 auto;
    font-family: "Arial", sans-serif;
  }
  
  /* Quotes Section */
  .quotes {
    width: 200px;
    font-size: 16px;
    color: #333;
    line-height: 1.8;
    font-family: "Georgia", serif;
  }
  
  .quotes.left {
    text-align: right;
    border-right: 2px solid #ddd;
    padding-right: 15px;
  }
  
  .quotes.right {
    text-align: left;
    border-left: 2px solid #ddd;
    padding-left: 15px;
  }
  
  .quote {
    margin-bottom: 20px;
    padding: 10px;
    border-radius: 8px;
    background: linear-gradient(145deg, #eafaf1, #d5e8e0);
    box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
    font-style: italic;
    color: #094e21;
    transition: transform 0.3s, box-shadow 0.3s;
  }
  
  .quote:hover {
    transform: scale(1.05);
    box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2);
  }
  
  /* Calendar Container */
  .calendar-container {
    width: 100%;
    max-width: 600px;
    text-align: center;
  }
  
  .calendar-title {
    font-size: 1.5rem;
    margin-bottom: 1rem;
  }
  
  .month-navigation {
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-bottom: 1rem;
  }
  
  .month {
    font-size: 1.5rem;
  }
  
  .nav-button {
    background: none;
    border: none;
    font-size: 1.5rem;
    cursor: pointer;
  }
  
  .nav-button:hover {
    color: #007bff;
  }
  
  /* Calendar Grid */
  .calendar-grid {
    display: grid;
    grid-template-columns: repeat(7, 1fr);
    gap: 8px;
  }
  
  /* Day Header */
  .day-header {
    font-weight: bold;
    text-transform: uppercase;
    color: #333;
  }
  
  /* Day Cell */
  .day-cell {
    width: 100%;
    padding-top: 100%; /* Maintain square aspect ratio */
    position: relative;
    background-color: #f0f0f0;
    border-radius: 8px;
    overflow: hidden;
    transition: background-color 0.3s;
  }
  
  .day-cell:hover {
    background-color: #e0e0e0;
  }
  
  .date-number {
    position: absolute;
    top: 5%;
    left: 5%;
    font-size: 0.9rem;
    font-weight: bold;
    color: #333;
  }
  
  /* Buttons for Day Cell */
  .buttons {
    position: absolute;
    bottom: 10%;
    left: 50%;
    transform: translateX(-50%);
    display: flex;
    gap: 5px;
  }
  
  .buttons button {
    padding: 4px 8px;
    font-size: 12px;
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
  
  /* Day Status Styles */
  .day-cell.done {
    background-color: #075427; /* Green */
    color: white;
  }
  
  .day-cell.in-progress {
    background-color: #ffeb3b; /* Yellow */
    color: black;
  }
  
  .day-cell.invalid {
    background-color: #cd7878; /* Red */
    color: white;
  }
  
  .day-cell.not-entered {
    background-color: #ddd; /* Light Gray */
    color: white;
  }
  
  /* Responsive Adjustments */
  @media (max-width: 768px) {
    .calendar-wrapper {
      flex-direction: column;
      align-items: center;
    }
  
    .quotes {
      width: 100%;
      text-align: center;
      border: none;
      padding: 0;
    }
  }
  </style>
  