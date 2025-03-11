<template>
  <v-container class="fill-height d-flex justify-center align-center">
    <v-card width="600" class="pa-4">
      <v-card-title class="d-flex align-center mb-3">
        <v-btn class="mr-2" icon @click="$router.push('/')">
          <v-icon>mdi-arrow-left</v-icon>
        </v-btn>
        <span>Add New Transaction</span>
      </v-card-title>

      <v-card-text>
        <v-form @submit.prevent="submitForm">
            <v-text-field v-model="tx.productId" label="Product ID" required></v-text-field>
            <v-text-field v-model="tx.productName" label="Product Name" required></v-text-field>
            <v-text-field v-model="tx.amount" label="Amount" required></v-text-field>
            <v-text-field v-model="tx.customerName" label="Customer Name" required></v-text-field>
            <v-text-field v-model="tx.status" label="Status" required></v-text-field>
            <v-text-field v-model="tx.transactionDate" label="Transaction Date" required></v-text-field>
            <v-text-field v-model="tx.createBy" label="Create By" required></v-text-field>
            <v-card-actions class="d-flex justify-end">
            <v-btn color="primary" type="submit">Save</v-btn>
          </v-card-actions>
        </v-form>
      </v-card-text>
    </v-card>
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
      this.tx.status = 'publish';
      await this.saveTx();
    },
    async saveAsDraft() {
      this.tx.status = 'draft';
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

<style scoped>
.fill-height {
  height: 100vh;
}
</style>