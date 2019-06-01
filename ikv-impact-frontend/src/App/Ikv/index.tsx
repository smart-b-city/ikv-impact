import React from "react";
import {
    Button,
    FormControl,
    Grid,
    InputLabel,
    MenuItem,
    Paper,
    TextField,
    Theme,
    Typography
} from "@material-ui/core";
import withStyles from "@material-ui/core/styles/withStyles";
import Select from "@material-ui/core/Select";
import createStyles from "@material-ui/core/styles/createStyles";

interface Props {
    classes: {
        form: string;
        textField: string;
    };
}

interface State {
    from: string;
    to: string;
    start: string;
    end: string;
}

const styles = ({spacing}: Theme) => createStyles({
    form: {
        padding: spacing(3, 3),
    },
    textField: {
    },
});

class Ikv extends React.PureComponent<Props, State> {

    state = {
        from: "",
        to: "",
        start: "8",
        end: "17"
    };

    handleChange = (name: string ) => (event: React.ChangeEvent<{ name?: string; value: unknown }>) => {
        // @ts-ignore
        this.setState({
            [name]: ((event.target) as any).value
        });
    };


    calculate = (event: React.MouseEvent<HTMLElement>) => {
        const {from, to, start, end} = this.state;
        alert(from+" "+to+" "+start+" "+end);
    };

    render() {
        const {classes} = this.props;
        const {from, to, start, end} = this.state;

        return (
            <Paper className={classes.form}>
                <Typography component="h3" variant="h4" align="center" color="textPrimary" gutterBottom>
                    Calculez votre indemnité kilométrique vélo
                </Typography>

                <Grid container spacing={2}>
                    <Grid item xs={12}>
                        <TextField
                            fullWidth
                            id="standard-name"
                            label="From"
                            className={classes.textField}
                            value={from}
                            onChange={this.handleChange('from')}
                        />
                    </Grid>
                    <Grid item xs={12}>
                        <TextField
                            fullWidth
                            id="standard-name"
                            label="To"
                            className={classes.textField}
                            value={to}
                            onChange={this.handleChange('to')}
                        />
                    </Grid>
                    <Grid item xs={6}>
                        <FormControl fullWidth>
                            <InputLabel htmlFor="start-simple">Start</InputLabel>
                            <Select
                                value={start}
                                onChange={this.handleChange('start')}
                                inputProps={{
                                    name: 'start',
                                    id: 'start-simple',
                                }}
                            >
                                <MenuItem value={7}>7</MenuItem>
                                <MenuItem value={8}>8</MenuItem>
                                <MenuItem value={9}>9</MenuItem>
                                <MenuItem value={10}>10</MenuItem>
                                <MenuItem value={11}>11</MenuItem>
                                <MenuItem value={12}>12</MenuItem>
                                <MenuItem value={13}>13</MenuItem>
                                <MenuItem value={14}>14</MenuItem>
                                <MenuItem value={15}>15</MenuItem>
                                <MenuItem value={16}>16</MenuItem>
                                <MenuItem value={17}>17</MenuItem>
                                <MenuItem value={18}>18</MenuItem>
                                <MenuItem value={19}>19</MenuItem>
                                <MenuItem value={20}>20</MenuItem>
                            </Select>
                        </FormControl>
                    </Grid>
                    <Grid item xs={6}>
                        <FormControl fullWidth>
                            <InputLabel htmlFor="start-simple">End</InputLabel>
                            <Select
                                value={end}
                                onChange={this.handleChange('end')}
                                inputProps={{
                                    name: 'end',
                                    id: 'end-simple',
                                }}
                            >
                                <MenuItem value="">
                                    <em>None</em>
                                </MenuItem>
                                <MenuItem value={7}>7</MenuItem>
                                <MenuItem value={8}>8</MenuItem>
                                <MenuItem value={9}>9</MenuItem>
                                <MenuItem value={10}>10</MenuItem>
                                <MenuItem value={11}>11</MenuItem>
                                <MenuItem value={12}>12</MenuItem>
                                <MenuItem value={13}>13</MenuItem>
                                <MenuItem value={14}>14</MenuItem>
                                <MenuItem value={15}>15</MenuItem>
                                <MenuItem value={16}>16</MenuItem>
                                <MenuItem value={17}>17</MenuItem>
                                <MenuItem value={18}>18</MenuItem>
                                <MenuItem value={19}>19</MenuItem>
                                <MenuItem value={20}>20</MenuItem>
                            </Select>
                        </FormControl>
                    </Grid>
                    <Grid item xs={9}/>
                    <Grid item xs={3}>
                        <Button fullWidth color="primary" variant="contained" onClick={this.calculate}>
                            Calculer
                        </Button>
                    </Grid>
                </Grid>
            </Paper>
        );
    }
}

export default withStyles(styles)(Ikv);
