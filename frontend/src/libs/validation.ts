import { z } from "zod"

const requiredString = z.string().trim().min(1, "Yêu cầu nhập")
