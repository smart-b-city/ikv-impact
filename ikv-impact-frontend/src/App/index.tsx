import React, {ChangeEvent, MouseEvent, useState} from "react";
import withConnect from "./withConnect";
import {Page} from "store/actions/navigation";
import {Container, InputLabel, Paper, TextField, Theme, Toolbar, Typography, MenuItem, FormControl, Grid, Button} from "@material-ui/core";
import TopBar from "./TopBar";
import createStyles from "@material-ui/core/styles/createStyles";
import withStyles from "@material-ui/core/styles/withStyles";
import Select from "@material-ui/core/Select";
import Ikv from "./Ikv";

interface Props {
    page: Page;
    classes: {
        heroContent: string
    }
}

const styles = ({palette, spacing}: Theme) => createStyles({
    heroContent: {
        padding: spacing(8, 0, 6),
    },
});

class App extends React.PureComponent<Props> {

    render() {
        const {classes} = this.props;
        return (
            <React.Fragment>
                <TopBar/>
                <Container maxWidth="sm" component="main" className={classes.heroContent}>
                    <Ikv/>
                </Container>
            </React.Fragment>

        );
    }
}

export default withStyles(styles)(withConnect(App));
