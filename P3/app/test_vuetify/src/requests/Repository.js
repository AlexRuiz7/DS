// Repository.js

import axios from 'axios';

const baseDomain = 'http://lvh.me:8081';
const baseURL = `${baseDomain}/api`;

export default axios.create({
  baseURL
})