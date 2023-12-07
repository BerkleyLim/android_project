/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React from 'react';
import { Provider } from 'react-redux';
import { legacy_createStore } from 'redux';
import rootReducer from './src/slices';
import Sample from './src/Sample';

const store = legacy_createStore(rootReducer)

// Redux 상태 관리 기법 제대로 쓰기 : https://code-masterjung.tistory.com/m/129
function App() {
  return (
    <Provider store={store}>
      <Sample/>
    </Provider>
  )
}


export default App;
