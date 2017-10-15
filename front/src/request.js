import axios from 'axios';

const API = 'http://192.168.0.142:8000/';

async function request(options) {
  return axios(options)
}


export const loginFetch = async function (userData) {
  return request({
    url: API + 'auth',
    method: 'POST',
    data: {
      ...userData
    }
  })
};

export const registerFetch = async function (userData) {
  return request({
    url: API + 'auth',
    method: 'PUT',
    data: {
      ...userData
    }
  })
};
