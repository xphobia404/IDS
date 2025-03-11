import axios from 'axios';

const API_URL = 'http://localhost:8070/';

const api = axios.create({
  baseURL: API_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

export const getData = async () => {
  try {
    const response = await api.get('transactions/list');
    return response.data;
  } catch (error) {
    console.error('Error fetching data:', error);
    throw error;
  }
};

export const getDetail = async (data) => {
  try {
    const response = await api.post('transactions/detail', data);
    return response.data;
  } catch (error) {
    console.error('Error fetching data:', error);
    throw error;
  }
};

export const insertTx = async (txData) => {
  try {
    const response = await api.post('transactions/insert', txData);
    return response.data;
  } catch (error) {
    console.error('Error Insert data:', error);
    throw error;
  }
};

export const updateTx = async (txData) => {
  try {
    const response = await api.post('transactions/update', txData);
    return response.data;
  } catch (error) {
    console.error('Error update data:', error);
    throw error;
  }
};

export default api;