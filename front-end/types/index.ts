export enum Role {
    ROLE_STUDENT,
    ROLE_LECTURER,
}

export interface User {
    userID?: number,
    email: string,
    password: string,
    role: Role,
    username: string,
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

