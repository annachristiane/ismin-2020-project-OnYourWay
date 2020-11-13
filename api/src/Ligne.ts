export interface hits {
  nhits: bigint;
  records: Array<record>;
}

export function getRecords(hits: hits): record[]{
  return hits.records;
}

export function getLignes(records: record[]): Ligne[]{
    const array: Ligne[] = [];
    for (let _i = 0; _i < records.length; _i++) {
       array.push(records[_i].fields);
    }
    return array;
}

export interface record {
  recordid: string;
  fields: Ligne;
}

export interface Ligne{
  status: string;
  id_line: string;
  transportsubmode: string;
  transportmode: string;
  shortname_line: string;
  name_line: string;
  shortname_groupoflines: string;
  networkname: string;
  operatorname: string;
}


