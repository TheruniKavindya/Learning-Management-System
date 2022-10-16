import { Card, Typography,TextField,Grid,Checkbox, Button} from '@mui/material';
import React from 'react';
import useStyles from './LoginStyle';
import { Link } from "react-router-dom";
import { useForm } from "react-hook-form";
import Image from '../Images/Login.webp';

function Login() {
    const classes = useStyles();
    const {
      handleSubmit,
      register,    
      formState: { errors },

    } = useForm();
    const onSubmit = (data) => {
      console.log(data);
     
    };
    return (
        <div  style={{
            backgroundColor: "#f7f8fa",
            backgroundImage: `url(${Image})`,
            backgroundPosition: 'center',
            backgroundSize: 'cover',
            backgroundRepeat: 'no-repeat',
            width: '100vw',
            height: '100vh',
            justifyContent: "center",
          }}>
          <div style={{ textAlign: "center", color: "cadetblue" }}>
            <Typography
              className={classes.title}
              variant="h3"
            >
              Welcome to LMS
            </Typography>
          </div>
          <form onSubmit={handleSubmit(onSubmit)}>

          <Card className={classes.card}>
          <Typography color="primary" variant='h4'>Login</Typography>
          <br/>
          <Grid>
            <Grid item>
            <TextField style={{ width: "70%", height: "78px" }} helperText={errors.email?.message} {...register("email", { required: " Email is required" })} error={Boolean(errors.email)} className={classes.textField} id="outlined-basic" name="email" label="Email*" variant="outlined" />
            <TextField style={{ width: "70%", height: "78px" }} {...register("password", { required: " Password is required" })} type="password" error={Boolean(errors.password)} helperText={errors.password?.message} className={classes.textField} id="outlined-basic" name="password" label="Password*" variant="outlined" />
           
            <div>
                <Checkbox
                color="primary"
                />
                Remember Me 
            </div>
            <div>
            <Link to="/studashboard">
              <Button type="submit" variant="outlined">Login</Button>
            </Link><Link to="/insdashboard">
              <Button type="submit" variant="outlined">Login</Button>
            </Link>
            
            </div>
            <Typography className={classes.title}>
            <strong>Not a member yet?</strong>
            <Link to="/signup">
              <Button  color="primary">SignUP</Button>
            </Link>
          </Typography>
            </Grid>
          </Grid>
          </Card>
          </form>
       
        </div>
    );
}

export default Login;