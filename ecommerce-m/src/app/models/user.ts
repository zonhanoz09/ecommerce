export interface User {
    id: number;
    username: string;
    password: string;
    role: Array<{authority}>;
    token?: string;
}