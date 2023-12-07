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

function App() {
  return (
    <Provider store={store}>
      <Sample/>
    </Provider>
  )
}


export default App;
