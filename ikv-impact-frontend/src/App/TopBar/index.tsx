import React from "react";
import {Theme, Toolbar, Typography} from "@material-ui/core";
import Button from "@material-ui/core/Button";
import withStyles from "@material-ui/core/styles/withStyles";
import createStyles from "@material-ui/core/styles/createStyles";
import AppBar from "@material-ui/core/AppBar";

interface Props {
    classes: {
        appBar: string;
        toolbar: string;
        toolbarTitle: string;
        link: string;
    };
}

const styles = ({palette, spacing}: Theme) => createStyles({
    appBar: {
        borderBottom: `1px solid ${palette.divider}`,
    },
    toolbar: {
        flexWrap: 'wrap',
    },
    toolbarTitle: {
        flexGrow: 1,
    },
    link: {
        margin: spacing(1, 1.5),
    },
});

class TopBar extends React.PureComponent<Props> {
    render() {
        const {classes} = this.props;
        return (<AppBar position="static" color="default">
            <Toolbar >
                <Typography variant="h6" color="inherit" noWrap  className={classes.toolbarTitle}>
                    SmartB
                </Typography>
                <Button href="#" color="primary" variant="outlined" className={classes.link}>
                    Impact IKV
                </Button>
            </Toolbar>
        </AppBar>
        );
    }
}

export default withStyles(styles)(TopBar);
