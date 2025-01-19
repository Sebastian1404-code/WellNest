import { Hono } from "hono";

import ai from "./api/ai";

const app = new Hono<{Bindings: Env}>();

// API routes
app.route("/api/v1/ai", ai);

export default app;
