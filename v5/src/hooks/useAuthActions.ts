import { useDispatch } from "react-redux";
import { User, authorize, logout } from "../slices/auth";
import { bindActionCreators } from "@reduxjs/toolkit";
import { useMemo } from "react";

/*
// 리액트 훅 적용 이후 - dispatch 적용 방법 1
const useAuthActions = () => {
  // 액션 함수
  const dispatch = useDispatch();

  return {
    authorize: (user: User) => dispatch(authorize(user)),
    logout: () => dispatch(logout())
  }
}

export default useAuthActions
*/

/*
// 리액트 훅 적용 이후 - dispatch 적용 방법 2
const useAuthActions = () => {
  // 액션 함수
  const dispatch = useDispatch();

  // 간결하게 사용 가능
  return bindActionCreators({authorize, logout}, dispatch);

}

export default useAuthActions
*/

// 리액트 훅 적용 이후 - dispatch 적용 방법 3
// useMemo로 적용 (ueEffect 사용시 의도치 않은 버그 생성 가능성있음)
const useAuthActions = () => {
  // 액션 함수
  const dispatch = useDispatch();

  // 간결하게 사용 가능
  return useMemo(() => bindActionCreators({authorize, logout}, dispatch),[dispatch]);

}

export default useAuthActions