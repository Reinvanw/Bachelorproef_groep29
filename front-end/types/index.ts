export enum Role {
    ROLE_STUDENT,
    ROLE_LECTURER,
}

export interface User {
    userID?: number,
    email: string,
    password: string,
    role: Role,
}

export interface NetworkSwitch {
    switchID?: number,
    userName: string,
    password: string,
    managementIP: number,
    hostname: string,
}
export interface Team {
    teamID?: number;
    teamName: string;
    users?: User[];
    swithch0?: NetworkSwitch;
}

export type StatusMessage = {
    message: string;
    type: "error" | "success";
};

export interface Login {
    email: string
    password: string
}