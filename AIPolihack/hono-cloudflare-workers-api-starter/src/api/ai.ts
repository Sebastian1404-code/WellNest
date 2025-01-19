import { Hono } from "hono";


const app = new Hono<{ Bindings: Env }>();

// Routes
app.post("/question", async (c) => {
    const { question } = await c.req.json();
    const textGenModel = "@cf/meta/llama-3-8b-instruct"; // Change this to your preferred model

    const aiResponse = (await c.env.AI.run(textGenModel, {
        max_tokens: 100, // Maximum number of tokens to generate. Change if you want to generate more or less.
        messages: [
            {
                role: "system",
                // System message to start the conversation. This can control the behavior of the model.
                content: `You are a very well-being person. You know how to help people make good habits and avoid bad ones. Always respond with a JSON object containing a single field called message. Do not include any text or explanation outside of the JSON object. The format should be {"message":"your content"} without escaping characters or new lines. i will send you a survey of a client in which i will provide you a question and an answer, 4 in total and please provide me 3 good goals for improving their wellbeing.The goals to be separated by a comma. Answer with 3 simple goals statements without using and conjuction between statements`
            },
            { role: "user", content: question },
        ],
    })) as { response: string };
    try {
        console.log(aiResponse.response);
        // const parsedResponse = JSON.parse(aiResponse.response); // Parse if response is JSON-like
        return c.json(aiResponse);
    }
    catch
    {
        console.log("Failed successufuly");
    }
});

/*app.get("/questions", async (c, next) => admin(c, next));
app.get("/questions", async (c) => {
  const db = getDatabase(c);
  const questionList = await db
    .select({
      userId: users.id,
      userEmail: users.email,
      questionId: questions.id,
      question: questions.question,
      answer: questions.answer,
      modelUsed: questions.modelUsed,
      processingTime: questions.processingTime,
    })
    .from(questions)
    .innerJoin(users, eq(questions.userId, users.id));

    return c.json(questionList);
});*/

export default app;
