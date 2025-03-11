<template>
  <v-container>
    <v-form @submit.prevent="submitForm">
      <v-text-field v-model="tx.productId" label="Product ID" required></v-text-field>
      <v-text-field v-model="tx.productName" label="Product Name" required></v-text-field>
      <v-text-field v-model="tx.amount" label="Amount" required></v-text-field>
      <v-text-field v-model="tx.customerName" label="Customer Name" required></v-text-field>
      <v-text-field v-model="tx.status" label="Status" required></v-text-field>
      <v-text-field v-model="tx.transactionDate" label="Transaction Date" required></v-text-field>
      <v-text-field v-model="tx.createBy" label="Create By" required></v-text-field>
      <v-btn class="mr-2" color="primary" @click="submitForm">Edit Transaction</v-btn>
    </v-form>
  </v-container>
</template>

<script>
import { insertTx, updateTx } from '@/api';

export default {
  props: ['existingTx'],
  data() {
    return {
      tx: this.existingTx || { productId: '', productName: '', amount: '', customerName: '', status: '',  transactionDate : '', createBy: ''},
    };
  },
  mounted(){
    if (this.existingTx !== null && this.existingTx !== undefined )
      this.tx = this.existingTx
  },
  methods: {
    async submitForm() {
      await this.saveTx();
    },
    async saveTx() {
      try {
        if (this.tx.id) {
          await updateTx(this.tx);
        } else {
          await insertTx(this.tx);
        }
        this.$emit('tx-saved');
      } catch (error) {
        console.error('Error saving tx:', error);
      }
    },
  },
};
</script>