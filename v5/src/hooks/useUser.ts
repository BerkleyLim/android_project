import { useSelector } from "react-redux"

// 리덕스 연동 훅 분리 -1 
const useUser = () => {
  // 아래는 RootReducer 타입 없이 적용함
  return useSelector(state => state.auth.user);
}

export default useUser