import { useEffect, useState } from "react";

function App() {
  const [message, setMessage] = useState("");

  useEffect(() => {
    fetch("http://localhost:8080/api/pb/hopesuccess", {
      cache: "no-store" //캐시 무시
    })
      .then((res) => res.text())
      .then((data) => setMessage(data));
  }, []);

  return <h1>{message}</h1>;
}

export default App;
