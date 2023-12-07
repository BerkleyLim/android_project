import { PayloadAction, createSlice } from "@reduxjs/toolkit";

// 타입 지정
export interface User {
  id: number;
  username: string;
  displayName: string;
}

// null or User 객체
interface AuthState {
  user: User | null;
}

// 초기 값 설정
const initialState: AuthState = {
  user: null,
}

// slice를 이용하여 reducer 생성
const authSlice = createSlice({
  name: 'auth',
  initialState,
  reducers: {
    // 로그인 시 authorize로 사용자 정보를 가져온다.
    authorize(state, action: PayloadAction<User>) {
      state.user = action.payload
    },
    // 다음은 로그아웃을 표현함
    logout(state) {
      state.user = null;
    }
  }
});

// reducer 저장
export default authSlice.reducer;
// 함수 설정
export const {authorize, logout} = authSlice.actions;