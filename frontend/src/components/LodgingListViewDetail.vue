<template>

    <v-card outlined>
        <v-card-title>
            LodgingList # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Name" v-model="item.name" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Address" v-model="item.address" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="PricePerDay" v-model="item.pricePerDay" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Rating" v-model="item.rating" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'LodgingListViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/lodgingLists/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

