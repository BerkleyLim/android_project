import React from 'react'
import { useSelector } from 'react-redux'
// import { RootState } from './slices'
import { Text, View } from 'react-native';
import useUser from './hooks/useUser';

const AuthStatus = () => {
  // 리액트 훅 적용 전
  // useSelector로 state 값 가져오기, user 값
  // const user = useSelector((state: RootState) => state.auth.user);
  
  // RootState 없이 가능
  // const user = useSelector((state) => state.auth.user);


  // 리액트 훅 적용 후
  const user = useUser();
  return (
    <View>
      <Text>
        {!!user ? user.displayName : '로그인하세요'}
      </Text>
    </View>
  )
}

export default AuthStatus