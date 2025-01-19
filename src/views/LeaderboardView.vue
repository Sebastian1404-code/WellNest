<template>
  <div class="leaderboard-container">
    <h1>Leaderboard</h1>
    <div class="card">
      <table>
        <thead>
          <tr>
            <th>Rank</th>
            <th>Nickname</th>
            <th>Score</th>
            <th>Today's Task Status</th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="user in users"
            :key="user.userId"
            :class="{ 'current-user': user.nickname === loggedInNickname }"
          >
            <td>{{ user.rank }}</td>
            <td>{{ user.nickname }}</td>
            <td>{{ user.score }}</td>
            <td>
              <span :class="getStatusClass(user.status)">
                {{ getStatusLabel(user.status) }}
              </span>
            </td>
          </tr>
        </tbody>
      </table>
    </div>

    <!-- Team Members Validation -->
    <div class="team-validation">
      <h2>Team Members Validation</h2>
      <div
        v-for="(member, index) in teamMembers"
        :key="index"
        class="team-member"
      >
        <p class="member-name">{{ member.nickname }}</p>
        <div class="actions">
          <button @click="validateMember(index, true)">✔️</button>
          <button @click="validateMember(index, false)">❌</button>
        </div>
        <p v-if="member.validated !== null" class="validation-result">
          {{ member.validated ? "Validated" : "Rejected" }}
        </p>
      </div>
    </div>
  </div>
</template>


<script setup>
import { ref, onMounted } from "vue";
import axios from "axios";

// Leaderboard data
const users = ref([]);

// Logged-in user's nickname
const loggedInNickname = ref(localStorage.getItem("nickname"));

// Hardcoded team members
const teamMembers = ref([
  { nickname: "Teammate1", validated: null },
  { nickname: "Teammate2", validated: null },
  { nickname: "Teammate3", validated: null },
]);

// Fetch leaderboard data
async function fetchLeaderboard() {
  try {
    const response = await axios.get("http://localhost:8080/api/leaderboard");
    users.value = response.data.map((user, index) => ({
      rank: index + 1, // Assign rank based on order
      userId: user.userId,
      nickname: user.nickname,
      score: user.score,
      status: user.status,
    }));
  } catch (error) {
    console.error("Failed to fetch leaderboard:", error);
  }
}

// Validate or reject a team member
function validateMember(index, isValid) {
  teamMembers.value[index].validated = isValid;
  console.log(
    `${teamMembers.value[index].nickname} ${
      isValid ? "validated" : "rejected"
    }`
  );
}

// Fetch leaderboard on component mount
onMounted(() => {
  fetchLeaderboard();
});

// Helper functions for leaderboard status
function getStatusLabel(status) {
  switch (status) {
    case 1:
      return "Pending";
    case 2:
      return "Validating";
    case 3:
      return "Completed";
    default:
      return "Unknown";
  }
}

function getStatusClass(status) {
  switch (status) {
    case 1:
      return "status-pending";
    case 2:
      return "status-validating";
    case 3:
      return "status-completed";
    default:
      return "status-unknown";
  }
}
</script>
<style scoped>
/* Leaderboard Container */
.leaderboard-container {
  max-width: 800px;
  margin: 50px auto;
  padding: 20px;
  background: linear-gradient(90deg, #afe2ab, #538838); /* Light Green Gradient */
  border-radius: 12px;
  text-align: center;
  color: white;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
}

/* Table Styling */
table {
  width: 100%;
  border-collapse: collapse;
  background: white;
  border-radius: 12px;
  overflow: hidden;
}

thead {
  background: #1e7937;
  color: white;
}

th,
td {
  padding: 15px;
  text-align: center;
  font-size: 14px;
}

tbody tr:nth-child(even) {
  background: #f9f9f9;
}

tbody tr:nth-child(odd) {
  background: #fff;
}

tbody tr:hover {
  background: #c9faaa;
}

/* Highlight Logged-In User */
.current-user {
  font-weight: bold;
  background-color: #82d09d;
  color: #073812;
}

/* Status Labels */
.status-pending {
  color: #b0ef8d;
  font-weight: bold;
}

.status-validating {
  color: #007bff;
  font-weight: bold;
}

.status-completed {
  color: #28a745;
  font-weight: bold;
}

.status-unknown {
  color: #dc3545;
  font-weight: bold;
}

/* Team Validation Section */
.team-validation {
  margin-top: 30px;
  background: white;
  border-radius: 12px;
  padding: 15px;
  color: #333;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

.team-member {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 10px;
}

.member-name {
  font-weight: bold;
  color: #1e7937;
}

.actions {
  display: flex;
  gap: 10px;
}

.actions button {
  border: none;
  padding: 6px 10px;
  font-size: 14px;
  cursor: pointer;
  border-radius: 5px;
  color: white;
}

.actions button:nth-child(1) {
  background-color: #28a745; /* Green */
}

.actions button:nth-child(1):hover {
  background-color: #218838;
}

.actions button:nth-child(2) {
  background-color: #dc3545; /* Red */
}

.actions button:nth-child(2):hover {
  background-color: #c82333;
}

.validation-result {
  margin-top: 5px;
  font-size: 14px;
  font-weight: bold;
}
</style>
