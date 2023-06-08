/* This example requires Tailwind CSS v2.0+ */
import { StarIcon } from '@heroicons/react/solid'
import { useState,useEffect } from 'react'
import * as React from 'react';
import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';
import axios from "axios";
import { Link } from 'react-router-dom';

import SketchExample from './ColorPickerModal';
import Navbar from './Home';
import Sidebar from './sidebar';

const reviews = [
  {
    id: 1,
    title: "Can't say enough good things",
    rating: 5,
    content: `
      <p>I was really pleased with the overall shopping experience. My order even included a little personal, handwritten note, which delighted me!</p>
      <p>The product quality is amazing, it looks and feel even better than I had anticipated. Brilliant stuff! I would gladly recommend this store to my friends. And, now that I think of it... I actually have, many times!</p>
    `,
    author: 'Risako M',
    date: 'May 16, 2021',
    datetime: '2021-01-06',
  },{
    id: 4,
    title: "Can't say enough good things",
    rating: 5,
    content: `
      <p>I was really pleased with the overall shopping experience. My order even included a little personal, handwritten note, which delighted me!</p>
      <p>The product quality is amazing, it looks and feel even better than I had anticipated. Brilliant stuff! I would gladly recommend this store to my friends. And, now that I think of it... I actually have, many times!</p>
    `,
    author: 'Risako M',
    date: 'May 16, 2021',
    datetime: '2021-01-06',
  },{
    id: 3,
    title: "Can't say enough good things",
    rating: 5,
    content: `
      I was really pleased with the overall shopping experience. My order even included a little personal, handwritten note, which delighted me!
      The product quality is amazing, it looks and feel even better than I had anticipated. Brilliant stuff! I would gladly recommend this store to my friends. And, now that I think of it... I actually have, many times!
    `,
    author: 'Risako M',
    date: 'May 16, 2021',
    datetime: '2021-01-06',
  },
  
  // More reviews...
]

function classNames(...classes) {
  return classes.filter(Boolean).join(' ')
}

export default function CandidateSession() {
  const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    bgcolor: 'background.paper',
    border: '2px solid #000',
    boxShadow: 24,
    p: 4,
  };
  const [open, setOpen] = React.useState(false);
  const  handleOpen = () => {setOpen(true)}
  const handleClose = () => setOpen(false);
  const [text,setText] = useState()
  const [addtext,setAddtext] = useState({title:'',content:''})

  const handleInput = (event) => {
    setAddtext({...addtext,[event.target.name]:event.target.value})

}
const title_chimie = "1.1: From Democritus to the 19th Century- Historical Developments in Chemistry"
const chimie = "Chemistry is the study of the material world. What are different materials made of? How is their composition and structure related to their properties? How does one material become transformed into another? These are the sorts of questions that have driven the development of chemistry.People have been using chemistry for a very long time. Medicines were obtained from plants in early societies all over the world. People made dyes for clothing and paints for houses. Metallurgy was practised in India and the Sahel, in Africa, before 1000 BC.The Greek philosopher, Democritus, is often cited as the earliest person to formulate an idea of atoms, although similar ideas were recorded in India around the same time. Democritus thought that all things were made of atoms. Atoms were very small, he thought. They were also indivisible. Although you could cut a piece of wood in half, and cut each of those pieces in half, at some point you would reach the stage at which the wood could not be cut any longer, because you had a slice that was one atom thick.There were an infinite variety of atoms, Democritus thought, making up an infinite variety of materials in the world. The properties of those atoms were directly responsible for the properties of materials. Water was made of water atoms, and water atoms were slippery. Iron was made of iron atoms, and iron atoms were strong and hard."
const getHeaders = () => {
  const token = localStorage.getItem("auth");
  return {headers :{    Authorization: `Bearer ${token}`}}
}
useEffect(() => {
  fetch("http://localhost:8080/expert/candidates",header)
  .then(response => response.json())
  // 4. Setting *data* to the API DATA that we received from the response above
  .then(data => setText(data))
  },[])
const header = getHeaders();
function DeleteHandler(event,id){
  event.preventDefault()
  axios.delete('http://localhost:8080/admin/texts/'+id, header).then(response => console.log(response)).catch(err => console.log(err.status))

  window.location.reload(false)
}
// axios.get('http://localhost:8080/admin/texts/get',header).then(response => setText(response.data)).catch(err => console.log(err.status))

function handleAnnotate(event,id){
  const header = getHeaders();
  event.preventDefault()
  
  axios.post('http://localhost:8080/expert/set-candidate/texts',header).then(response => console.log(response)).catch(err => console.log(err.status))
}
function handleAdd(event){
  const header = getHeaders();
  console.log(header)
  event.preventDefault()
  
  axios.post('http://localhost:8080/admin/texts',{title:addtext.titre,content:addtext.Text

  },header).then(response => console.log(response,addtext)).catch(err => console.log(err.status))
}
  return (
    <><Navbar></Navbar><Sidebar></Sidebar><div className="bg-white">
      <div style = {{marginTop:-67}} className="max-w-2xl mx-auto py-16 px-4 sm:py-24 sm:px-6 lg:max-w-7xl lg:px-8">
        <div className="bg-white">
          <div className="-ml-4 -mt-2 flex items-center justify-between flex-wrap sm:flex-nowrap">
            <div className="ml-4 mt-2">
            </div>
          
          </div>
        </div>
        <div className="mt-6 pb-10 border-t border-b border-gray-200 divide-y divide-gray-200 space-y-10">
          {text?.map((text) => (
            <div key={text.id} className="pt-10 lg:grid lg:grid-cols-12 lg:gap-x-8" style={{ marginBottom: -35 }}>
              <div className="lg:col-start-5 lg:col-span-8 xl:col-start-4 xl:col-span-9 xl:grid xl:grid-cols-3 xl:gap-x-8 xl:items-start">

                <div className="mt-4 lg:mt-6 xl:mt-0 xl:col-span-2">
                  <h3 className="text-sm font-medium text-gray-900">{text.title}{title_chimie}</h3>

                  <div
                    className="mt-3 space-y-6 text-sm text-gray-500">{chimie}
                  </div>

                </div>
              </div>

              {/* <div className="mt-6 flex items-center text-sm lg:mt-0 lg:col-start-1 lg:col-span-4 lg:row-start-1 lg:flex-col lg:items-start xl:col-span-3">
                <p className="font-medium text-gray-900">{review.author}</p>
                <time
                  dateTime={review.datetime}
                  className="ml-4 border-l border-gray-200 pl-4 text-gray-500 lg:ml-0 lg:mt-2 lg:border-0 lg:pl-0"
                >
                  {review.date}
                </time>
              </div> */}
              <div className="bg-white px-4 py-5 border-b border-gray-200 sm:px-6">
                <div className="-ml-4 -mt-2 flex items-center justify-between flex-wrap sm:flex-nowrap">

                  <div className="ml-4 mt-2 flex-shrink-0" style={{ marginLeft: 855 }}
                  >
                    <button
                  onClick={handleAnnotate}
                      type="button"
                      className="relative inline-flex items-center px-4 py-2 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
                    >
Annotate                    </button>


                  </div>
                </div>
              </div>
            </div>
          ))}

        </div>

      </div>
    </div></>
  )
}
