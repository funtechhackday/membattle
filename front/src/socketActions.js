

function prepareSocket(data) {
  data.user = {
    username: window.localStorage.getItem('username'),
    password: window.localStorage.getItem('password'),
  };
  return data
}


export default {
  chooseMem(id) {
    console.log(id)
    return JSON.stringify(prepareSocket({
      type: "CHOOSE_MEM",
      id
    }));
  },
  getStage() {
    return JSON.stringify(prepareSocket({
      type: "GET_STAGE",
    }));
  },
};
