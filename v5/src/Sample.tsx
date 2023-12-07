import React from 'react'
import { RefreshControl, ScrollView } from 'react-native'
import AuthStatus from './AuthStatus'
import AuthButtons from './AuthButtons'

const Sample = () => {
  const [refreshing, setRefreshing] = React.useState(false);
    // 이부분은 pull-to-refresh를 위한 함수 로직
    const onRefresh = React.useCallback(async () => {
      setRefreshing(true);
      setTimeout(() => {
        setRefreshing(false);
      }, 2000);
    }, []);
  return (
    <ScrollView
      // contentContainerStyle={styles.scrollView}
      refreshControl={
        // <RefreshControl refreshing={refreshing} onRefresh={onRefresh} enabled={false}/>
        <RefreshControl refreshing={refreshing} onRefresh={onRefresh}/>
        // <RefreshControl refreshing={refreshing} />
      }
    >
      <AuthStatus/>
      <AuthButtons/>
    </ScrollView>
  )
}

export default Sample