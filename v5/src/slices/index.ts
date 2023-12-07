import { combineReducers } from "redux";
import auth from "./auth";


// reducer 생성
const rootReducer = combineReducers({
  auth,
})

// rootState 타입 선언
export type RootState = ReturnType<typeof rootReducer>;

// RootState 없이 타입 추론하는 코드
declare module 'react-redux' {
  interface DefaultRootState extends RootState {}
}

// reducer 적용, store에 적용을 위해
export default rootReducer;
