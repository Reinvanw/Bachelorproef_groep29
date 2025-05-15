export enum Role {
    ROLE_STUDENT,
    ROLE_LECTURER,
}

export interface User {
    userID: number,
    email: string,
    password: string,
    role: Role,
}

