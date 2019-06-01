import React from "react";
import ReactDOM from "react-dom";
import {hot} from "react-hot-loader";
import {Provider} from "react-redux";
import CssBaseLine from "@material-ui/core/CssBaseline";
import {MuiThemeProvider} from "@material-ui/core/styles";
import "typeface-roboto";
import store from "./store";
import theme from "./theme";
import App from "./App";

const HotModule = hot(module)(() => (
    <Provider store={store}>
        <MuiThemeProvider theme={theme}>
            <CssBaseLine/>
            <App/>
        </MuiThemeProvider>
    </Provider>
));

ReactDOM.render(<HotModule/>, window.document.getElementById("app"));
