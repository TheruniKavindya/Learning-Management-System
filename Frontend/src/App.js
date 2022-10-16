import './App.css';
import MainRouter from "./components/MainRouter";
import { ThemeProvider } from '@mui/material/styles';
import theme from "./Theme";

function App() {
  return (
    <div >
      <ThemeProvider theme={theme}>
        <MainRouter/>
      </ThemeProvider>

    </div>
  );
}

export default App;
