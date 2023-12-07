import React from 'react'
// import { useDispatch } from 'react-redux'
// import { authorize, logout } from './slices/auth';
import { Button, View } from 'react-native';
import useAuthActions from './hooks/useAuthActions';

const AuthButtons = () => {
  // 리액트 훅 적용 전
  // // 액션 함수
  // const dispatch = useDispatch();
  
  // // 로그인 버튼
  // const onPressLogin = () => {
  //   dispatch(
  //     authorize({
  //       id:1,
  //       username: 'Berkley',
  //       displayName: 'berkley'
  //     })
  //   );
  // }

  // // 로그아웃 버튼
  // const onPressLogout = () => {
  //   dispatch(logout())
  // }
  
  
  // 리액트 훅 적용 후
  const { authorize, logout } = useAuthActions();

  return (
    <View>
      <Button title="로그인" onPress={() => authorize({id:1, username: 'Berkley', displayName: 'berkley'})}/>
      <Button title="로그아웃" onPress={() => logout()}/>
      {/* <Button title="로그인" onPress={onPressLogin}/>
      <Button title="로그아웃" onPress={onPressLogout}/> */}
    </View>
  )
}

export default AuthButtons