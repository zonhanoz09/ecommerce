﻿import { Role } from "./role";

export interface User {
    id: number;
    username: string;
    password: string;
    role: Role;
    token?: string;
}