import { SpeechProvider } from '@speechly/react-client';
import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import { Provider } from './context/context';
import './index.css';
ReactDOM.render(
	<SpeechProvider
		appId='bda5ce26-6275-40b3-899c-01d30a0be6cd'
		language='en-US'
	>
		<Provider>
			<App />
		</Provider>
	</SpeechProvider>,
	document.getElementById('root'),
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
